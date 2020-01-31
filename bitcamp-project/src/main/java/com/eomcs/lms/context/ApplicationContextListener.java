package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {

  void contextInitionalize(Map<String, Object> context);

  void contextDestroyed(Map<String, Object> context);


}
