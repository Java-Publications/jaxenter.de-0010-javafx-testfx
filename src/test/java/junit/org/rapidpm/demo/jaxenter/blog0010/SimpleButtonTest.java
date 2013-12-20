package junit.org.rapidpm.demo.jaxenter.blog0010;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;
import static org.loadui.testfx.Matchers.hasLabel;

import static org.loadui.testfx.Assertions.verifyThat;

/**
 * Created by ts40 on 20.12.13.
 */
@Category(TestFX.class)
public class SimpleButtonTest extends GuiTest {

    @Override
    protected Parent getRootNode() {
        final VBox vBox = new VBox();
        final Button btn = new Button();
        btn.setId("btn");
        btn.setText("Click me");
        vBox.getChildren().add(btn);
        return vBox;
    }

    @Test
    public void shouldClickButton()
    {
        final Button button = find( "#btn" );
        button.setOnAction( new EventHandler<ActionEvent>()
        {
            @Override
            public void handle( ActionEvent actionEvent )
            {
                button.setText( "Was clicked" );
            }
        } );

        click(button);

        verifyThat( "#btn", hasLabel("Was clicked") );
    }

}
