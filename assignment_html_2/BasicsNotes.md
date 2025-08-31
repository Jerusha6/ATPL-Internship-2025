
# HTML Basics Notes

# Page 1: Introduction to HTML & Document Structure

# What is HTML?

* HTML stands for HyperText Markup Language.
* It is used to create webpages and structure web content.
* Web browsers read HTML files and display the content.

# Basic Structure of an HTML Document
```html
<!DOCTYPE html>
<html>
  <head>
    <title>Page Title</title>
  </head>
  <body>
   <!-- for content -->
  </body>
</html>
```

* `<!DOCTYPE html>` tells the browser that this is an HTML5 document.
* `<html>` is the root element.
* `<head>` contains page info like title and metadata.
* `<title>` sets the page title visible on the browser tab.
* `<body>` contains all the visible content on the page.


# Common HTML Tags & Their Uses

# Headings

* Used for titles and subtitles.
* `<h1>` is the largest heading, `<h6>` is the smallest.

```html
<h1>Main Heading</h1>
<h2>Subheading</h2>
```

# Paragraphs

* Used to write text.

```html
<p>This is a paragraph.</p>
```

# Links

* Used to create clickable links.

```html
<a href="https://www.example.com">Visit Example</a>
```

# Images

* To add pictures.
* Use `src` attribute for image source and `alt` for alternate text.

```html
<img src="image.jpg" alt="Description of image">
```

# Lists, Divisions & Text Formatting Tags

# Lists

* Ordered List (Numbered)

```html
<ol>
  <li>First item</li>
  <li>Second item</li>
</ol>
```

* Unordered List (Bulleted)

```html
<ul>
  <li>Apple</li>
  <li>Banana</li>
</ul>
```

# Divisions and Sections

* `<div>` groups content, useful for styling or layout.
```html
<div>
  <p>This is inside a div.</p>
</div>
```

# Text Formatting Tags

* `<b>` makes text bold.
* `<i>` makes text italic.
* `<u>` underlines text.
* Example:

```html
<p><b>Bold</b> and <i>Italic</i> text.</p>
```

# Attributes, Comments & Simple Example

# Attributes

* Extra info added to tags.
* Examples:

  * `href` for links
  * `src` for images
  * `alt` for image description
  * `id` and `class` for CSS styling


```html
<a href="https://example.com" id="link1" class="nav-link">Example</a>
```

# Comments

* Notes inside code, not shown on the webpage.
* Syntax:

```html
<!-- This is a comment -->
```


# Example
```html
<!DOCTYPE html>
<html>
<head>
  <title>My Simple Page</title>
</head>
<body>
  <h1>Welcome!</h1>
  <p>This is a simple HTML page.</p>
  <a href="https://www.google.com">Go to Google</a>
  <h2>My List</h2>
  <ul>
    <li>Item one</li>
    <li>Item two</li>
  </ul>
</body>
</html>
```