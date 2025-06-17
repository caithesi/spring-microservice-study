import requests

def format_url(url, variables):
    return url.format(**variables)

def test(url):
    r = requests.get(url)
    return r
