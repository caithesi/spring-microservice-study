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
x = requests.get(format_url("{localhost}/licensing-service", variables),
                 headers={"X-Config-Token":"myroot", "Content-Type":"application/json"})
print(x.text)

