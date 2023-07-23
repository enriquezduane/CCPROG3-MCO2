package model;

import model.VM.NormalVM;
import model.core.*;

public class Factory {
  private boolean isCreated;
  private NormalVM normalVM;

  public Factory() {
    isCreated = false;
    normalVM = new NormalVM();
  }

  public boolean getIsCreated() {
    return isCreated;
  }

  public void setIsCreated(boolean isCreated) {
    this.isCreated = isCreated;
  }

  public void addItemsInVendingMachine(String[] name, int[] quantity, int[] price, double[] calories) {
    normalVM.getSlots().add(new ItemSlot(name, quantity, price, calories));
  }

  public int getNumSlots() {
    return normalVM.getSlots().size();
  }
}
