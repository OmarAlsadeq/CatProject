package com.example.demo.model;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;
import elemental.json.JsonObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class GpsMapping extends VerticalLayout {

    private final GoogleMap googleMap;
    private final Binder<Cat> binder = new Binder<>(Cat.class);
    private final Image catImage;
    private final TextField nameField;

    public GpsMapping() {
        // Initialize Google Map component
        googleMap = new GoogleMap("API_KEY", null, null);
        googleMap.setSizeFull();
        googleMap.setZoom(10);

        // Initialize image component for cat image
        catImage = new Image();
        catImage.setWidth("300px");
        catImage.setHeight("300px");

        // Initialize text field for cat name
        nameField = new TextField();
        nameField.setPlaceholder("Enter cat name");

        // Initialize button to add cat
        Button addButton = new Button("Add Cat", VaadinIcon.PLUS.create());
        addButton.addClickListener(event -> addCat());

        // Add components to layout
        add(googleMap, new Div(catImage, nameField), addButton);

        // Set up binder for cat object
        binder.bindInstanceFields(this);

        // Add event listener for map click events
        googleMap.addClickListener(event -> {
            Cat cat = new Cat();
            cat.setLatitude(event.getLatitude());
            cat.setLongitude(event.getLongitude());
            binder.setBean(cat);
        });

        // Add event listener for cat image upload
        catImage.getElement().addEventListener("load", event -> {
            InputStream inputStream = new ByteArrayInputStream(binder.getBean().getImage());
            StreamResource streamResource = new StreamResource("catImage.jpg", () -> inputStream);
            catImage.setSrc(streamResource);
        });
    }

    private void addCat() {
        try {
            // Validate cat name
            binder.validate();
            if (binder.isValid()) {
                // Save cat to database
                Cat cat = binder.getBean();
                cat.setImage(IOUtils.toByteArray(catImage.getElement().getNode().getFeature("value")));
                Cat savedCat = catRepository.save(cat);

                // Display notification with cat name and location
                Notification.show("Cat '" + savedCat.getCatName() + "' added at location ("
                                        + savedCat.getLatitude() + ", " + savedCat.getLongitude() + ")",
                                3000, Notification.Position.BOTTOM_CENTER)
                        .addThemeVariants(NotificationVariant.LUMO_SUCCESS);

                // Clear form
                binder.setBean(new Cat());
                catImage.setSrc("");
                nameField.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
