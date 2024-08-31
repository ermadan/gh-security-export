package org.example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.RequestHandler
import jdk.jpackage.internal.Arguments.CLIOptions.context
import java.util.*


class MRequestHandler : RequestHandler<Integer, String> {
    override fun handleRequest(p0: Integer?, context: Context?): String {
        val advisories = extract(Date(), publish)
        context?.getLogger()?.log("String found: " + event.message());
        return advisories.
    }
}

