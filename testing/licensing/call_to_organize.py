import requests
import json

import sys
import os

from pathlib import Path
from variables import load_variables
from make_request import format_url, test



# get path to current file's directory
this_dir = Path(__file__).parent

# path to resource.json in the same folder
resource_path = this_dir / "variables.json"

variables = load_variables(resource_path,
                           local_variables = {
                           })

print(variables)

x = requests.get(format_url("http://localhost:8080/v1/organization-call/1/discovery-client", variables),
                 headers={"Content-Type":"application/json"})
# print(json.dumps(x.json(), indent=2))
