# Guides
1. Convention
2. Checkstyle


## 1. Adding Concentional commits to the project

### Commit types
- Permitted types : 'feat', 'fix', 'perf', 'refactor', 'style', 'test', 'build', 'ops', 'docs', 'merge'

- Install and copy to .git/hooks
```shell
npm install --global git-conventional-commits 
cp commit-msg .git/hooks/commit-msg
```

## 2. Checkstyle:
 ```shell
mvn org.apache.maven.plugins:maven-checkstyle-plugin:3.1.1:check

```
```shell
mvn org.apache.maven.plugins:maven-checkstyle-plugin:3.1.1:check | grep "Checkstyle"

```