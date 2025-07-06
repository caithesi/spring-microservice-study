import requests
import json

import sys
import os
sys.path.append('..')  # Add parent directory

from variables import load_variables
from make_request import format_url, test

variables = load_variables("config/variables.json",
                            local_variables = {
                             "licensing": "licensing-service"
                           })

print(variables)
print(format_url("{localhost}/{licensing}/default", variables))
x = requests.get(format_url("{localhost}/{licensing}/dev", variables) , headers={"X-Config-Token":"myroot"})

print(json.dumps(x.json(), indent=2))
