package model.VM.special;

import model.core.Item;

public class SpecialItems {

  public class Beef extends Item {
    private String message;

    public Beef() {
      super("Beef", 10, 9, 200.12);
      message = "Adding tender beef slices...";
    }

    public String getMessage() {
      return message;
    }
  }

  public class Pork extends Item {
    private String message;

    public Pork() {
      super("Pork", 10, 9, 250.43);
      message = "Adding pork slices...";
    }

    public String getMessage() {
      return message;
    }
  }

  public class Tofu extends Item {
    private String message;

    public Tofu() {
      super("Tofu", 10, 3, 80.34);
      message = "Placing soft tofu cubes...";
    }

    public String getMessage() {
      return message;
    }
  }

  public class Mushrooms extends Item {
    private String message;

    public Mushrooms() {
      super("Mushrooms", 10, 4, 20.32);
      message = "Adding mushrooms...";
    }

    public String getMessage() {
      return message;
    }
  }

  public class Cabbage extends Item {
    private String message;

    public Cabbage() {
      super("Cabbage", 10, 4, 15.76);
      message = "Layering in shredded cabbages...";
    }

    public String getMessage() {
      return message;
    }
  }

  public class ThaiChillies extends Item {
    private String message;

    public ThaiChillies() {
      super("Thai Chillies", 10, 3, 5.34);
      message = "Sprinkling Thai chillies...";
    }

    public String getMessage() {
      return message;
    }
  }

  public class Sausage extends Item {
    private String message;

    public Sausage() {
      super("Sausage", 10, 7, 180.69);
      message = "Mixing in sausage slices...";
    }

    public String getMessage() {
      return message;
    }
  }

  public class Kimchi extends Item {
    private String message;

    public Kimchi() {
      super("Kimchi", 10, 6, 50.23);
      message = "Adding zesty kimchi...";
    }

    public String getMessage() {
      return message;
    }
  }

}
