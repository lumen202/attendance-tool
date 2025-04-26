package sms.admin;

import dev.finalproject.database.DataManager;
import dev.sol.core.application.FXApplication;
import dev.sol.core.application.loader.FXLoaderFactory;
import dev.sol.core.scene.FXSkin;
import javafx.scene.image.Image;
import sms.admin.app.RootLoader;

public class App extends FXApplication {

    @Override
    public void initialize() throws Exception {
        configureApplication();
        initializeDataset();

        // Initialize UI
        initialize_application();

    }

    private void configureApplication() {
        setTitle("Student Management System - Attendance Tool");
        setSkin(FXSkin.PRIMER_LIGHT);
        getApplicationStage().getIcons().add(
                new Image(getClass()
                        .getResource("/sms/admin/assets/img/logo.png")
                        .toExternalForm()));
    }

    public void initializeDataset() {
        DataManager.getInstance().initializeData();

    }

    private void initialize_application() {
        RootLoader rootLoader = (RootLoader) FXLoaderFactory
                .createInstance(RootLoader.class,
                        App.class.getResource("/sms/admin/app/ROOT.fxml"))
                .addParameter("scene", applicationScene)
                .addParameter("OWNER", applicationStage)
                .initialize();

        // Add stylesheet to scene
        applicationScene.getStylesheets().add(
            getClass().getResource("/sms/admin/app/styles.css").toExternalForm()
        );

        applicationStage.requestFocus();
        rootLoader.load();

    }
}
