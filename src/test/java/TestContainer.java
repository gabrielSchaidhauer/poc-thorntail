import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.JAR)
public class TestContainer {

    @ArquillianResource
    InitialContext context;

    @Test
    public void testDataSourceIsBound() throws Exception {
        DataSource ds = (DataSource) context.lookup("java:jboss/datasources/appDS");
        assertNotNull( ds );
    }
}
