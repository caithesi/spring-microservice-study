import json
def load_variables(global_variables_link = '../variables.json',
                    workspace_variables_link = 'variables.json',
                    local_variables = {}):
    # Load global config, then licensing (licensing overrides global)
    variables = {}

    with open(global_variables_link) as fd:
        variables.update(json.load(fd))

    with open(workspace_variables_link) as fd:
        variables.update(json.load(fd))
    variables.update(local_variables)
    return variables