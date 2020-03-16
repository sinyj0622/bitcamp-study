package com.eomcs.util;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.apache.ibatis.io.Resources;

// 역할: 환경정보
// - 클래스를 찾아 객체를 생성한다.
// - 객체가 일을 하는데 필요로하는 의존객체를 주입한다.
// - 객체의 생성과 소멸을 관리한다.
// (환경정보)
public class ApplicationContext05 {

  // 클래스 이름을 담을 저장소
  ArrayList<String> classNames = new ArrayList<>();

  // 객체 저장소
  HashMap<String, Object> objPool = new HashMap<>();

  public ApplicationContext05(String packageName) throws Exception {
    // 패키지의 실제 파일 시스템 경로를 알아낸다
    // System.out.println("ApplicationContext: " + packageName);
    String packagePath = packageName.replace('.', '/');

    // System.out.println("ApplicationContext: " + packagePath);
    File path = Resources.getResourceAsFile(packagePath
    /* 패키지명을 파일 시스템 경로로 바꿔서 전달한다. */);
    // System.out.println("ApplicationContext: " + path.getAbsolutePath());

    // 해당 경로를 뒤져서 모든 클래스의 이름을 알아낸다
    findClasses(path, packageName);

    // 클래스 이름으로 객체를 생성한다.
    createInstance();


  }

  private void createInstance() throws Exception {
    for (String className : classNames) {
      // 클래스 이름으로 클래스 정보를 가져온다.
      Class<?> clazz = Class.forName(className);
      if (!isConcreteClass(clazz)) {
        continue; // 객체를 생성할 수 없는 경우 건너 뛴다
      }

      // 클래스의 생성자 정보를 알아낸다
      Constructor<?> constructor = clazz.getConstructors()[0];

      // 생성자의 파라미터 정보를 알아낸다.
      Parameter[] params = constructor.getParameters();

      // 생성자 넘겨 줄 파라미터 객체를 준비한다
      ArrayList<Object> values = new ArrayList<>();
      for (Parameter param : params) {
        values.add(getParameterInstance(param));
      }

      // 생성자를 호출하여 객체를 준비한다
      Object obj = constructor.newInstance(values.toArray());

      // 생성된 객체를 보관소에 저장한다.
      objPool.put(className, obj);
    }

  }

  private Object getParameterInstance(Parameter param) {
    Collection<?> objs = objPool.values();

    // 먼저 객체 보관소에 파라미터 객체가 있는지 검사한다.
    for (Object obj : objs) {
      // 있으면 리턴한다
      if (param.getType().isInstance(obj)) {
        return obj;
      }
    }

    // 없으면 파라미터 객체를 생성한다.
    return createParameterInstance(param);
  }

  private Object createParameterInstance(Parameter param) {
    // TODO Auto-generated method stub
    return null;
  }

  private void findClasses(File path, String packageName) {
    File[] files = path.listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        if (file.isDirectory() //
            || (file.getName().endsWith(".class") //
                && !file.getName().contains("$")))
          return true;
        return false;
      }
    });
    for (File f : files) {
      String classOrPackageName = packageName + "." + f.getName().replace(".class", "");
      if (f.isFile()) {
        // System.out.println("ApplicationContext: " + classOrPackageName);
        classNames.add(classOrPackageName);
      } else {
        findClasses(f, classOrPackageName);
      }
    }
  }

  private boolean isConcreteClass(Class<?> clazz) {
    if (clazz.isInterface() // 인터페이스인 경우
        || clazz.isEnum() // Enum 타입인 경우
        || Modifier.isAbstract(clazz.getModifiers())) { // 추상클래스인 경우
      return false; // 이런 클래스는 객체를 생성할 수 없기 때문에 건너 뛴다
    }
    return true;
  }
}
