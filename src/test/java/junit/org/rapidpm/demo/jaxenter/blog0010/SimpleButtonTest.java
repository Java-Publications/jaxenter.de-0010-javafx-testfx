package junit.org.rapidpm.demo.jaxenter.blog0010;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.Matchers.hasText;

/**
 * Created by ts40 on 20.12.13.
 */
@Category(TestFX.class)
public class SimpleButtonTest extends GuiTest {

    @Override
    protected Parent getRootNode() {
        final Button btn = new Button();
        btn.setId("btn");
        btn.setText("Hello World");
        btn.setOnAction((actionEvent)-> btn.setText( "was clicked" ));
        return btn;
    }

    @Test
    public void shouldClickButton()
    {
        final Button button = find( "#btn" );

        click(button);

//        verifyThat( "#btn", hasText("Was clicked") );
        verifyThat( "#btn", hasText("was clicked") );
    }

}
