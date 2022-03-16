module fr.uvsq.iutvelizy.proj2.javafxproj2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.uvsq.iutvelizy.proj2.javafxproj2 to javafx.fxml;
    exports fr.uvsq.iutvelizy.proj2.javafxproj2.view;
    exports fr.uvsq.iutvelizy.proj2.javafxproj2.model;
    exports fr.uvsq.iutvelizy.proj2.javafxproj2.utils;
}