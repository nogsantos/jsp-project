<article>
    <blockquote>
        <%
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 40; i++) {
                str.append(" position ");
                str.append(" >>>> ");
                str.append(i);
                if (i % 2 == 1) {
                    str.append("<br />");
                }
            }
            out.println(str);
        %>
    </blockquote>
</article>