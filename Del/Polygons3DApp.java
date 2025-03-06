import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.CullFace;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;

public class Polygons3DApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Создаем текстовое поле для ввода количества полигонов
        TextField polygonField = new TextField();
        polygonField.setPromptText("Введите количество полигонов");

        // Создаем кнопку для отображения фигуры
        Button showButton = new Button("Показать фигуру");

        // Создаем группу для отображения 3D фигуры
        Group root = new Group();
        VBox vbox = new VBox(10, polygonField, showButton, root);
        Scene scene = new Scene(vbox, 800, 600);

        // Устанавливаем камеру для 3D сцены
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(30);
        scene.setCamera(camera);

        // Обрабатываем нажатие кнопки
        showButton.setOnAction(event -> {
            try {
                int polygons = Integer.parseInt(polygonField.getText());
                root.getChildren().clear();
                root.getChildren().add(create3DShape(polygons));
            } catch (NumberFormatException e) {
                polygonField.setText("Ошибка: введите целое число");
            }
        });

        primaryStage.setTitle("3D Polygons App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MeshView create3DShape(int polygons) {
        // Создаем сферу с заданным количеством полигонов
        Sphere sphere = new Sphere(200);
        sphere.setDrawMode(DrawMode.LINE);
        sphere.setCullFace(CullFace.NONE);

        // Преобразуем сферу в MeshView для более точного контроля над полигонами
        MeshView meshView = new MeshView(createSphereMesh(polygons, 200));
        meshView.setDrawMode(DrawMode.LINE);
        meshView.setCullFace(CullFace.NONE);
        meshView.setTranslateX(400);
        meshView.setTranslateY(300);

        return meshView;
    }

    private TriangleMesh createSphereMesh(int divisions, float radius) {
        TriangleMesh mesh = new TriangleMesh();
        int numDivisions = Math.max(divisions, 3);

        // Создаем вершины
        for (int i = 0; i <= numDivisions; i++) {
            double lat = Math.PI * i / numDivisions;
            for (int j = 0; j <= numDivisions; j++) {
                double lon = 2 * Math.PI * j / numDivisions;
                float x = radius * (float) (Math.sin(lat) * Math.cos(lon));
                float y = radius * (float) (Math.sin(lat) * Math.sin(lon));
                float z = radius * (float) Math.cos(lat);
                mesh.getPoints().addAll(x, y, z);
            }
        }

        // Создаем полигоны
        for (int i = 0; i < numDivisions; i++) {
            for (int j = 0; j < numDivisions; j++) {
                int v0 = i * (numDivisions + 1) + j;
                int v1 = v0 + 1;
                int v2 = v0 + (numDivisions + 1);
                int v3 = v1 + (numDivisions + 1);
                mesh.getFaces().addAll(v0, v0, v1, v1, v2, v2);
                mesh.getFaces().addAll(v1, v1, v3, v3, v2, v2);
            }
        }

        return mesh;
    }

    public static void main(String[] args) {
        launch(args);
    }
}