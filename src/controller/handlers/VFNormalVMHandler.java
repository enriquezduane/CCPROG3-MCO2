package controller.handlers;

import model.*;
import model.core.*;
import view.*;

public class VFNormalVMHandler {
  VFNormalVM vendNormalVM;
  Factory model;

  public VFNormalVMHandler(VFNormalVM vendNormalVM, Factory model) {
    this.vendNormalVM = vendNormalVM;
    this.model = model;

    this.vendNormalVM.addBtnReturnToFeature(e -> handleReturnToFeature());
    this.vendNormalVM.addBtnInsertOne(e -> handleInsertOne());
    this.vendNormalVM.addBtnInsertFive(e -> handleInsertFive());
    this.vendNormalVM.addBtnInsertTen(e -> handleInsertTen());
    this.vendNormalVM.addBtnBuy(e -> handleBuy());
  }

  private void handleReturnToFeature() {
    System.out.println("Return");
  }

  private void handleInsertOne() {
    Currency currency = model.getInsertedCurrency();
    model.getInsertedCurrency().setOne(currency.getOne() + 1);
    vendNormalVM.setTxtFields(currency.getOne(), currency.getFive(), currency.getTen(), currency.getTotalAmount());
  }

  private void handleInsertFive() {
    Currency currency = model.getInsertedCurrency();
    model.getInsertedCurrency().setFive(currency.getFive() + 1);
    vendNormalVM.setTxtFields(currency.getOne(), currency.getFive(), currency.getTen(), currency.getTotalAmount());
  }

  private void handleInsertTen() {
    Currency currency = model.getInsertedCurrency();
    model.getInsertedCurrency().setTen(currency.getTen() + 1);
    vendNormalVM.setTxtFields(currency.getOne(), currency.getFive(), currency.getTen(), currency.getTotalAmount());
  }

  private void handleBuy() {
    System.out.println("Buy");
  }
}
