package liquibase;

import liquibase.util.ExpressionMatcher;
import liquibase.util.StringUtil;

import java.util.*;

/**
 * Encapsulates logic for evaluating if a set of runtime contexts matches a context expression string.
 */
public class ContextExpression {

    private final HashSet<String> contexts = new HashSet<>();
    private String originalString;

    public ContextExpression() {
    }

    public ContextExpression(String... contexts) {
        if (contexts.length == 1) {
            parseContextString(contexts[0]);
            originalString = contexts[0];
        } else {
            for (String context : contexts) {
                parseContextString(context.toLowerCase());
            }
            originalString = StringUtil.join(contexts, ",");
        }
    }

    public ContextExpression(String contexts) {
        parseContextString(contexts);
        this.originalString = contexts;
    }

    public ContextExpression(Collection<String> contexts) {
        if (contexts != null) {
            for (String context : contexts) {
                this.contexts.add(context.toLowerCase());
            }
            originalString = StringUtil.join(contexts, ",");
        }
    }

    private void parseContextString(String contexts) {
        contexts = StringUtil.trimToNull(contexts);

        if (contexts == null) {
            return;
        }
        for (String context : StringUtil.splitAndTrim(contexts, ",")) {
            this.contexts.add(context.toLowerCase());
        }

    }

    public boolean add(String context) {
        return this.contexts.add(context.toLowerCase());
    }

    public Set<String> getContexts() {
        return Collections.unmodifiableSet(contexts);
    }

    @Override
    public String toString() {
        if (originalString != null) {
            return originalString;
        }
        return "(" + StringUtil.join(new TreeSet<>(this.contexts), "), (") + ")";
    }

    /**
     * Returns true if the passed runtime contexts match this context expression
     */
    public boolean matches(Contexts runtimeContexts) {
        boolean isThereAnyRequiredContextFilter = this.contexts != null ? this.contexts.stream().anyMatch(context -> context.startsWith("@")) : false;
        if (runtimeContexts == null || (runtimeContexts.isEmpty())) {
            return true;
        }
        if (this.contexts.isEmpty() && !isThereAnyRequiredContextFilter) {
            return true;
        }

        for (String expression : this.contexts) {
            if (matches(expression, runtimeContexts)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(String expression, Contexts runtimeContexts) {
        if (runtimeContexts == null) {
            runtimeContexts = new Contexts();
        }
        return ExpressionMatcher.matches(expression, runtimeContexts.getContexts());
    }

    public boolean isEmpty() {
        return this.contexts.isEmpty();
    }

    public String getOriginalString() {
        return originalString;
    }
}
