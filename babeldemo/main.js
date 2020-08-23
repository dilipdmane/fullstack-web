function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

function start() {
  class Bookmark extends React.Component {
    constructor(props) {
      super(props);

      _defineProperty(this, "title", this.props.title);

      _defineProperty(this, "titleStyle", {
        color: "red"
      });

      console.log("Bookmark Component created");
    }

    render() {
      return /*#__PURE__*/React.createElement("li", null, /*#__PURE__*/React.createElement("h2", {
        style: this.titleStyle
      }, this.title), /*#__PURE__*/React.createElement("a", {
        href: this.props.href
      }, this.props.descriptions), /*#__PURE__*/React.createElement("br", null), /*#__PURE__*/React.createElement("button", {
        onClick: () => {
          this.title = this.title + "-Changed..";
          this.setState({});
        }
      }, "Click Button"));
    } // end of render


  } //end of class Bookmark


  _defineProperty(Bookmark, "defaultProps", {
    descriptions: "Not Applicable"
  });

  ReactDOM.render( /*#__PURE__*/React.createElement("div", null, /*#__PURE__*/React.createElement("h1", null, "Bookmarks"), /*#__PURE__*/React.createElement("ul", null, /*#__PURE__*/React.createElement(Bookmark, {
    title: "Etherient",
    href: "https://www.etherient.com",
    descriptions: "The home page of Etherient"
  }), /*#__PURE__*/React.createElement(Bookmark, {
    title: "zammetti",
    href: "https://www.zammetti.com"
  }))), document.getElementById('mainContainer'));
}
