package com.mcode.fisco.ui.views;

import com.mcode.fisco.ui.MainLayout;
import com.mcode.fisco.ui.utils.FieldFactory;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Profile | FISCO")
public class ProfileView extends HorizontalLayout {

    private Div mainContent = new Div();

    public ProfileView() {

        mainContent.setWidthFull();
        mainContent.getStyle().set("padding", "5px");
        addContent();
        add(mainContent);
    }

    private void addContent() {

        TextField firstName = FieldFactory.createTextField("Ime");
        TextField lastName = FieldFactory.createTextField("Prezime");
        EmailField eMail = new EmailField("E-mail");
        TextField oib = FieldFactory.createTextField("OIB");
        TextField phoneNumber = FieldFactory.createTextField("Mobitel");
        Button saveButton = new Button("Spremi");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        FormLayout formLayout = new FormLayout();
        formLayout.add(firstName, lastName, eMail, oib, phoneNumber);

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("600px", 3)
        );

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton);
        buttonLayout.setWidthFull();

        mainContent.add(formLayout, buttonLayout);

    }

}
