## Completion of skipped code in [bazel build gerrit, David Ostrovsky](http://ostrovsky.org/gerrit/bazel-build-gerrit/#(1))


bezel version
```bash
bazel version
Build label: 0.19.2
Build target: bazel-out/k8-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Mon Nov 19 16:25:09 2018 (1542644709)
Build timestamp: 1542644709
Build timestamp as int: 1542644709

```
There are 4 commits. 

start from
```bash
$ bazel run printy HELLO BAZEL

```
end with
```bash
$ bazel query //...
//:printy_stamped
//:printy
//:printy_lib
//:gen_version

```

  
