package model.VM.special;

import model.core.Item;

/**
 * The SpecialItems class contains inner classes representing various special items available in the special vending machine.
 * Each inner class extends the Item class and provides additional information and messages specific to the respective special item.
 */
public class SpecialItems {

  /**
   * The class represents the special item "Beef" available in the special vending machine.
   */
  public class Beef extends Item {
    private String message;

     /**
     * Constructs a new Beef instance with its initial state.
     * It sets the attributes of the "Beef" special item, such as name, quantity, price, and calories.
     * Additionally, it initializes a message describing the action related to the special item.
     */

    public Beef() {
      super("Beef", 10, 9, 200.12);
      message = "Adding tender beef slices...";
    }

      /**
       * @return The message describing the action related to the special item.
       */

    public String getMessage() {
      return message;
    }
  }

   /**
     * The class represents the special item "Pork" available in the special vending machine.
     */
  public class Pork extends Item {
    private String message;

   /**
    * Constructs a new Pork instance with its initial state.
    * It sets the attributes of the "Pork" special item, such as name, quantity, price, and calories.
    * Additionally, it initializes a message describing the action related to the special item.
    */

    public Pork() {
      super("Pork", 10, 9, 250.43);
      message = "Adding prok slices...";
    }
 /**
   * @return The message describing the action related to the special item.
   */
    public String getMessage() {
      return message;
    }
  }

  /**
    * The class represents the special item "Tofu" available in the special vending machine.
    */
  public class Tofu extends Item {
    private String message;

  /**
    * Constructs a new Tofu instance with its initial state.
    * It sets the attributes of the "Tofu" special item, such as name, quantity, price, and calories.
    * Additionally, it initializes a message describing the action related to the special item.
    */
    public Tofu() {
      super("Tofu", 10, 3, 80.34);
      message = "Placing soft tofu cubes...";
    }

    /**
      * @return The message describing the action related to the special item.
      */

    public String getMessage() {
      return message;
    }
  }

  /**
   * The class represents the special item "Mushrooms" available in the special vending machine.
   */

  public class Mushrooms extends Item {
    private String message;

     /**
      * Constructs a new Mushrooms instance with its initial state.
      * It sets the attributes of the "Mushrooms" special item, such as name, quantity, price, and calories.
      * Additionally, it initializes a message describing the action related to the special item.
      */

    public Mushrooms() {
      super("Mushrooms", 10, 4, 20.32);
      message = "Adding mushrooms...";
    }

     /**
      * @return The message describing the action related to the special item.
      */

    public String getMessage() {
      return message;
    }
  }

   /**
     * The class represents the special item "Cabbage" available in the special vending machine.
     */
  public class Cabbage extends Item {
    private String message;

   /**
     * Constructs a new Cabbage instance with its initial state.
     * It sets the attributes of the "Cabbage" special item, such as name, quantity, price, and calories.
     * Additionally, it initializes a message describing the action related to the special item.
     */

    public Cabbage() {
      super("Cabbage", 10, 4, 15.76);
      message = "Layering in shredded cabbages...";
    }

    /**
      * @return The message describing the action related to the special item.
      */
    public String getMessage() {
      return message;
    }
  }


  /**
   * The class represents the special item "Thai Chillies" available in the special vending machine.
   */

  public class ThaiChillies extends Item {
    private String message;

    /**
      * Constructs a new ThaiChillies instance with its initial state.
      * It sets the attributes of the "Thai Chillies" special item, such as name, quantity, price, and calories.
      * Additionally, it initializes a message describing the action related to the special item.
      */

    public ThaiChillies() {
      super("Thai Chillies", 10, 3, 5.34);
      message = "Sprinkling Thai chillies...";
    }

    /**
      * @return The message describing the action related to the special item.
      */
    public String getMessage() {
      return message;
    }
  }

   /**
     * The class represents the special item "Sausage" available in the special vending machine.
     */
  public class Sausage extends Item {
    private String message;

    /**
      * Constructs a new Sausage instance with its initial state.
      * It sets the attributes of the "Sausage" special item, such as name, quantity, price, and calories.
      * Additionally, it initializes a message describing the action related to the special item.
      */

    public Sausage() {
      super("Sausage", 10, 7, 180.69);
      message = "Mixing in sausage slices...";
    }

    /**
      * @return The message describing the action related to the special item.
      */
    public String getMessage() {
      return message;
    }
  }

   /**
     * The class represents the special item "Kimchi" available in the special vending machine.
     */

  public class Kimchi extends Item {
    private String message;
   /**
     * Constructs a new Kimchi instance with its initial state.
     * It sets the attributes of the "Kimchi" special item, such as name, quantity, price, and calories.
     * Additionally, it initializes a message describing the action related to the special item.
     */

    public Kimchi() {
      super("Kimchi", 10, 6, 50.23);
      message = "Adding zesty kimchi...";
    }

    /**
      * @return The message describing the action related to the special item.
      */
    public String getMessage() {
      return message;
    }
  }

}
