package Java_test;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import static org.easymock.EasyMock.*;
import junit.framework.TestCase;

public class LoginServletTest extends TestCase {

    public void testLoginFailed() throws Exception {
        LoginServlet servlet = new LoginServlet();
        HttpServletRequest request = createNiceMock(HttpServletRequest.class);
        expect(request.getParameter("username")).andReturn("admin");
        expect(request.getParameter("password")).andReturn("1234");
        replay(request);
        try {
//            servlet.doPost(request, null);
            fail("Not caught exception!");
        } catch (RuntimeException re) {
            assertEquals("Login failed.", re.getMessage());
        }
        verify(request);
    }

    public void testLoginOK() throws Exception {
        // create mock:
        HttpServletRequest request = createNiceMock(HttpServletRequest.class);
        final ServletContext contextObj = createMock(ServletContext.class);
        RequestDispatcher dispatcherObj = createMock(RequestDispatcher.class);
        // set behavior:
        expect(request.getParameter("username")).andReturn("admin");
        expect(request.getParameter("password")).andReturn("123456");
        expect(contextObj.getNamedDispatcher("dispatcher")).andReturn(
                dispatcherObj);
        dispatcherObj.forward(request, null);
        // done!
        replay(request);
        replay(contextObj);
        replay(dispatcherObj);
        // test:
        LoginServlet servlet = new LoginServlet() {
            private static final long serialVersionUID = 1L;
            public ServletContext getServletContext() {
                return contextObj;
            }
        };
        servlet.doPost(request, null);
        // verify:
        verify(request);
        verify(contextObj);
        verify(dispatcherObj);
    }
}

