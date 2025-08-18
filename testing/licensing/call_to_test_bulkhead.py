import aiohttp
import argparse
import asyncio
import time


URLS = {
    "thread_pool_mock_on_function": "http://localhost:8080/v1/test-resilience4j/test-threadpool-bulkhead-on-function-mock-call",
    "thread_pool_mock_on_class": "http://localhost:8080/v1/test-resilience4j/test-threadpool-bulkhead-on-class-mock-call"
}

NUM_REQUESTS = 500
CONCURRENT_LIMIT = 25  # max concurrent requests at once

sem = asyncio.Semaphore(CONCURRENT_LIMIT)


async def fetch(session, i, URL):
    async with sem:
        start = time.time()
        try:
            async with session.get(URL, timeout=10) as response:
                duration = time.time() - start
                text = await response.text()
                return f"[{i:03}] ✅ {response.status} in {duration:.2f}s with resp {text}"
            return None
        except Exception as e:
            duration = time.time() - start
            return f"[{i:03}] ❌ ERROR after {duration:.2f}s: {e}"
    return None


async def main():
    parser = argparse.ArgumentParser(description="Async HTTP load tester")
    parser.add_argument("-u", "--url_key", required=True, choices=URLS.keys(), help="Base URL key")
    parser.add_argument("-s", "--sleep", required=True,
                        help="how long will the request require")
    # parser.add_argument("-n", "--num_requests", type=int, default=NUM_REQUESTS, help="Number of requests to send")
    # parser.add_argument("-c", "--concurrent", type=int, default=CONCURRENT_LIMIT, help="Max concurrent requests")
    args = parser.parse_args()
    path = f"{URLS[args.url_key]}/{args.sleep}"

    async with aiohttp.ClientSession() as session:
        tasks = [fetch(session, i, path) for i in range(NUM_REQUESTS)]
        for future in asyncio.as_completed(tasks):
            result = await future
            print(result)


if __name__ == "__main__":
    asyncio.run(main())
