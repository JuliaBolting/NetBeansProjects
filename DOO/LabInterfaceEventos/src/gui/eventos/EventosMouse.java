import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouse implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("[EventosMouse] mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent evento) {
        System.out.println("[EventosMouse] mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent evento) {
        System.out.println("[EventosMouse] mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent evento) {
        System.out.println("[EventosMouse] mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent evento) {
        System.out.println("[EventosMouse] mouse exited");
    }
}
