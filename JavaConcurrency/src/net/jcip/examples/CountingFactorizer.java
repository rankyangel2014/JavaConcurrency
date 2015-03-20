package net.jcip.examples;

import java.math.BigInteger;
import java.util.concurrent.atomic.*;
import javax.servlet.*;

import net.jcip.annotations.*;

/**
 * CountingFactorizer
 *
 * Servlet that counts requests using AtomicLong
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class CountingFactorizer extends GenericServlet implements Servlet {
	// 利用原子变量处理计数问题
	private final AtomicLong count = new AtomicLong(0);

	public long getCount() {
		return count.get();
	}

	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		count.incrementAndGet();
		encodeIntoResponse(resp, factors);
	}

	void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
	}

	BigInteger extractFromRequest(ServletRequest req) {
		return null;
	}

	BigInteger[] factor(BigInteger i) {
		return null;
	}
}
