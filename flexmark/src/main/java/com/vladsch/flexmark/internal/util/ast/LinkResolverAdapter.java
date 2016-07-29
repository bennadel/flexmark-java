package com.vladsch.flexmark.internal.util.ast;

import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.node.Node;

import java.util.Collection;

public class LinkResolverAdapter extends NodeAdaptedVisitor<LinkResolvingHandler<?>> implements LinkResolvingVisitor<Node> {
    public LinkResolverAdapter(LinkResolvingHandler<?>... handlers) {
        super(handlers);
    }

    public LinkResolverAdapter(LinkResolvingHandler<?>[]... handlers) {
        super(handlers);
    }

    public LinkResolverAdapter(Collection<LinkResolvingHandler<?>> handlers) {
        super(handlers);
    }

    @Override
    public ResolvedLink resolveLink(Node node, NodeRendererContext context, ResolvedLink link) {
        LinkResolvingHandler<?> handler = myCustomHandlersMap.get(node.getClass());
        if (handler != null) {
            return handler.resolveLink(node, context, link);
        }
        return link;
    }
}