cmp.markdown
============
The cmp.markdown library contains DSL functions to generate markdown documents with Clojure.
Functions ar provided for standard markdown and Github flavoured markdown extensions.

[![Clojars Project](https://img.shields.io/clojars/v/org.soulspace.clj/cmp.markdown.svg)](https://clojars.org/org.soulspace.clj/cmp.markdown)
[![cljdoc badge](https://cljdoc.org/badge/org.soulspace.clj/cmp.markdown)](https://cljdoc.org/d/org.soulspace.clj/cmp.markdown)
![GitHub](https://img.shields.io/github/license/soulspace-org/cmp.markdown)



Usage
-----
Include cmp.markdown as a dependency.

Leiningen

```
[org.soulspace.clj/cmp.markdown "0.4.1"]
```

Example
-------
Example code to generate markdown

```
(ns markdown.example
  (:require [org.soulspace.cmp.md.markdown-dsl :as md]))

(def md
  (md/markdown
    (md/h1 "Markdown Example")
    (md/p "This is an example of the programmatic generation of markdown files with the cmp.markdown library.")
    (md/h2 "Markdown Formats")
    (md/p "The cmp.markdown library supports the following markdown formats:\n"
       (md/ol (md/link "Markdown" "http://daringfireball.net/projects/markdown/")
           (md/link "Github flavoured markdown" "https://help.github.com/articles/github-flavored-markdown")))))

(println md)
```

Generated markdown 

```
Markdown Example
================
This is an example of the programmatic generation of markdown files with the cmp.markdown library.

Markdown Formats
----------------
The cmp.markdown library supports the following markdown formats:
1. [Markdown](http://daringfireball.net/projects/markdown/)
2. [Github flavoured markdown](https://help.github.com/articles/github-flavored-markdown)
```

Copyright
---------
© 2012-2020 Ludger Solbach

License
-------
[Eclipse Public License 1.0](http://www.eclipse.org/legal/epl-v10.html)

Code Repository
---------------
[https://github.com/lsolbach/CljComponents](https://github.com/soulspace-org/cmp.markdown)

