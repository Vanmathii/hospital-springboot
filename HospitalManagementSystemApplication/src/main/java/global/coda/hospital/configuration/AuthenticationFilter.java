package global.coda.hospital.configuration;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)

public class AuthenticationFilter implements Filter {
	private static final Logger LOGGER = LogManager.getLogger(AuthenticationFilter.class);
    UUID requestId = UUID.randomUUID();

    @Override
		public void doFilter(ServletRequest request, javax.servlet.ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
              LOGGER.info("In filter");		
              request.setAttribute("requestId", requestId);
              chain.doFilter(request, response);
		}
}