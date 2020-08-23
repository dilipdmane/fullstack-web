function start(){
  class Bookmark extends React.Component{
    constructor(props)
    {
      super(props);
      console.log("Bookmark Component created");
    }
    static defaultProps ={ descriptions:"Not Applicable"};
    //static propTypes ={ descriptions : PropTypes.number};
    title = this.props.title;
    titleStyle = {color:"red"};

    render()
    {
      return (
        <li>
        <h2 style={this.titleStyle}>{this.title}</h2>
        <a href={this.props.href}>{this.props.descriptions || unknosn}</a>
        <br></br>
        <button onClick={ ()=> {
          this.title = this.title + "-Changed..";
          this.setState({});
        }}>
        Click Button
        </button>
        </li>

      );
    }// end of render
  }//end of class Bookmark

  Bookmark.propTypes = { descriptions:PropTypes.number};

  ReactDOM.render(
    <div>
    <h1>Bookmarks</h1>
    <ul>
    <Bookmark title={"Etherient"} href={"https://www.etherient.com"} descriptions={"The home page of Etherient"}/>
    <Bookmark title={"zammetti"} href={"https://www.zammetti.com"} />
    </ul>
    </div>,document.getElementById('mainContainer')
  );
}
