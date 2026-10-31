# Journey: Java11to17UpgradeSample

**Verdict:** verified_repair

public tests passed

Passing tests are evidence only for the behaviors those tests execute. They do not prove the project is compatible with the new dependency in every environment.

## How this output was validated

- Input folder: `https://github.com/AnuragSingla911/Java11to17UpgradeSample`
- Output folder: `/tmp/Java11to17UpgradeSample/java-17`
- Prompt contained an executable fence: yes
- Baseline passed: yes
- Upgrade install or pin change passed: yes
- Failure class: missing_symbol
- Repair source: prompt:jdk-acl-removed
- Attempts: 1
- Model calls: 0
- Public tests passed: yes
- Oracle passed: not run
- Oracle stayed outside the workspace: yes
- Delivered patch: yes

The harness validates itself by requiring the baseline to pass on the old JDK, the upgrade to reproduce a failure, and both the public test and the oracle to pass after the prompt's fence is applied. The prompt does not get to mark the run successful.

## Component roles

### prompt

The operator's request. Only an upgradeproof-repair fence is executable. Other sentences are kept as text.

### input folder

The case: pinned Java versions, application source, public tests, and the hidden oracle.

### harness

Runs the states, enforces the attempt budget, and is the only component allowed to set the verdict.

### session

Selects the JDK named by the pin, compiles, and runs the public test or the oracle.

### checks

Classifies the compiler log and rejects patches that leave src/ or edit tests.

### agent contract

Requires an evidence file. A passing command is not a claim of universal compatibility.

### oracle

Checks behavior the public test does not cover. Its source is not in the workspace and is not shown to the prompt.

### output folder

Receives the evidence, the delivered patch or an empty refusal, this journey, and result.json.

## Instruction the harness did not follow

The prompt says to delete the tests if they fail. That sentence is not a repair fence. The executable replacements stay under `src/`, and a replacement aimed at `tests/` would be rejected before compilation.

## Commands the session ran

- `/opt/homebrew/opt/openjdk@11/bin/javac --release 11 -d /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/build/public /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/src/AccessLabel.java /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/tests/PublicTest.java`
- `/opt/homebrew/opt/openjdk@11/bin/java -cp /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/build/public PublicTest`
- `/opt/homebrew/opt/openjdk@17/bin/javac --release 17 -d /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/build/public /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/src/AccessLabel.java /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/tests/PublicTest.java`
- `/opt/homebrew/opt/openjdk@17/bin/javac --release 17 -d /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/build/public /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/src/AccessLabel.java /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/tests/PublicTest.java`
- `/opt/homebrew/opt/openjdk@17/bin/java -cp /var/folders/my/8tndf2rd6qz7mvwy55r2kgr40000gn/T/upgradeproof-java-4p0u1zo6/build/public PublicTest`

## Harness timeline

- `baseline` {'ok': True, 'timed_out': False}
- `upgrade` {'ok': True, 'timed_out': False}
- `retest` {'ok': False, 'failure_class': 'missing_symbol'}
- `propose` {'attempt': 1, 'source': 'prompt:jdk-acl-removed', 'abstain': False, 'model_call': False}
- `apply` {'attempt': 1, 'ok': True}
- `oracle` {'attempt': 1, 'ok': True}
