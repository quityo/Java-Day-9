package kodlamaio.hrms.core.utilities.business;

import kodlamaio.hrms.core.utilities.results.Result;

public class BusinessRules {
	public static Result run(final Result... logics) {
		for (var result : logics) {

            if (!result.isSuccess()) {
                return result;
            }

        }
        return null;

    }
}