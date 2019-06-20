genrule(
    name = "gen_version",
    stamp = 1,
    cmd = "echo $$(cat bazel-out/volatile-status.txt bazel-out/stable-status.txt | grep PRINTY | cut -d ' ' -f 2) > $@",
    outs = ["gen_version.txt"],
)

genrule(
    name = "printy_stamped",
    srcs = [":printy_deploy.jar"],
    tools = [":gen_version.txt"],
    cmd = " && ".join([
        "r=$$PWD",
        "t=$$(mktemp -d)",
        "GEN_VERSION=$$(cat $(location :gen_version.txt))",
        "cd $$t",
        "unzip -q $$r/$<",
        "sed -Ei \"s/^(Implementation-Version:[[:blank:]]).*/\\1$$GEN_VERSION/\" META-INF/MANIFEST.MF",
        "zip -qr $$r/$@ ."]),
    outs = ["printy_stamped.jar"],
)

java_library(
    name = "printy_lib",
    srcs = glob(["src/main/java/**/*.java"]),
    deps = ["@guava//jar"],
)

java_binary(
    name = "printy",
    deploy_manifest_lines = [
        "Implementation-Version: 1.0",
        "Implementation-Vendor: Gerrit User Conference 2016",
    ],
    main_class = "org.gerritcon.mv2016.Printy",
    runtime_deps = [":printy_lib"],
)
