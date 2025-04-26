package sms.admin.app;

import dev.sol.core.application.loader.FXLoader;
import dev.sol.core.registry.FXControllerRegister;
import javafx.scene.Scene;

public class RootLoader extends FXLoader {

    @Override
    public void load() {
        Scene scene = (Scene) params.get("scene");
        scene.setRoot(root);
        
        // Add stylesheet explicitly
        String css = getClass().getResource("styles.css").toExternalForm();
        scene.getStylesheets().add(css);

        RootController controller = loader.getController();
        FXControllerRegister.INSTANCE.register("ROOT", controller);

        controller.addParameter("SCENE", scene)
                .addParameter("OWNER", params.get("OWNER"))
                .load();
    }
}
