package reflection;

public class Test{
  private Boolean testBoolean;
  private String name;

  public Test(){};

  public Boolean getTestBoolean() {
    return testBoolean;
  }

  public void setTestBoolean(Boolean testBoolean) {
    this.testBoolean = testBoolean;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Test{" +
        "testBoolean=" + testBoolean +
        ", name='" + name + '\'' +
        '}';
  }
}