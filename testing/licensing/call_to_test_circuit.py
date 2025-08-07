import asyncio
import aiohttp
import time

URL = "http://localhost:8080/v1/test-resilience4j/test-circuit-breaker-mock-db-call/true"
NUM_REQUESTS = 100
CONCURRENT_LIMIT = 20  # max concurrent requests at once

sem = asyncio.Semaphore(CONCURRENT_LIMIT)

async def fetch(session, i):
    async with sem:
        start = time.time()
        try:
            async with session.get(URL, timeout=10) as response:
                duration = time.time() - start
                text = await response.text()
                return f"[{i:03}] ✅ {response.status} in {duration:.2f}s"
            return None
        except Exception as e:
            duration = time.time() - start
            return f"[{i:03}] ❌ ERROR after {duration:.2f}s: {e}"
    return None


async def main():
    async with aiohttp.ClientSession() as session:
        tasks = [fetch(session, i) for i in range(NUM_REQUESTS)]
        for future in asyncio.as_completed(tasks):
            result = await future
            print(result)

if __name__ == "__main__":
    asyncio.run(main())
