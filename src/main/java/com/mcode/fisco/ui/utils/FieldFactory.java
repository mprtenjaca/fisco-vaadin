package com.mcode.fisco.ui.utils;

import com.vaadin.flow.component.textfield.TextField;

public class FieldFactory {

    private FieldFactory() {

    }

    public static TextField createTextField(String label){
        TextField textField = new TextField(label);
        return textField;
    }

}
