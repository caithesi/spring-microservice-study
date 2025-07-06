import requests
import json

import sys
import os
import argparse

sys.path.append('..')  # Add parent directory

from variables import load_variables
from make_request import format_url, test

parser = argparse.ArgumentParser()
parser.add_argument('--encrypt', required=True)
args = parser.parse_args()

variables = load_variables("config/variables.json",
                            local_variables = {
                             
                           })

print(variables)
x = requests.post(format_url("{localhost}/encrypt", variables),
                  data = args.encrypt, 
                  headers={"X-Config-Token":"myroot", "Content-Type":"application/json"})
print(x.text)

