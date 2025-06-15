import requests
import json

import sys
import os
sys.path.append('..')  # Add parent directory

from variables import load_variables
from make_request import format_url, test

variables = load_variables(local_variables = {
                             "organizationId": "organizationId"
                           })

print(variables)

x = test(format_url("{localhost}/{organization}/{organizationId}/license/1", variables))

print(json.dumps(x.json(), indent=2))
