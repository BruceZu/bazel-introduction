package org.gerritcon.mv2016;


import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;

public class Printy {
  public static void main(String[] argv) throws IOException {
    System.out.println("run command line: " + Joiner.on(' ').join(argv));
    if (argv.length > 0 && argv[0].equals("--version")) {

      new Printy().printVersion();

      return;
    }
    new Printy().mainImpl(argv);
  }

  void mainImpl(String[] argv) {

    System.out.println(Joiner.on(' ').join(argv));
  }

  void printVersion() throws IOException {
    URLClassLoader cl = (URLClassLoader) getClass().getClassLoader();
    URL url = cl.findResource("META-INF/MANIFEST.MF");
    Manifest manifest = new Manifest(url.openStream());
    Attributes main = manifest.getMainAttributes();
    String version = main.getValue("Implementation-Version");
    if (Strings.isNullOrEmpty(version)) {
      System.err.println("no version specified");
    } else {
      System.err.println(version);
    }
  }
}
