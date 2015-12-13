class Trip extends React.Component {
  render() {
    return <li className="list-group-item">
      {this.props.trip.origin.name} <i className="fa fa-arrow-right"></i> {this.props.trip.destination.name}
      <a href={'addtrip?id=' + this.props.trip.id} className="btn btn-default btn-sm pull-right">
      	<i className="fa fa-cart-arrow-down"></i>
      </a>
    </li>;
  }
}

class TripList extends React.Component {
  render() {
    return <ul className="list-group">
      {this.props.data.map(trip => <Trip key={trip.id} trip={trip} />)}
    </ul>;
  }
}
  
class Search extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: []
    };
  }
  
  componentDidMount() {
    this.componentWillReceiveProps(this.props);
  }
  
  componentWillReceiveProps({query}) {
    fetch('api/trips', {
      method: 'POST',
      body: query
    }).then(res => {
      if(res.ok) {
        return res.json();
      } else {
        return Promise.reject(res.statusText);
      }
    }).then(data => {
      this.setState({data});
    }).catch(console.error.bind(console));
  }

  render() {
    return <TripList data={this.state.data} />;
  }
}

const source = new Bloodhound({
	datumTokenizer: Bloodhound.tokenizers.obj.whitespace('name'),
	queryTokenizer: Bloodhound.tokenizers.whitespace,
	prefetch: 'api/campuses',
	identify: obj => obj.id
});

$('input[type="search"]').typeahead({
	minLength: 0,
	hint: true,
	highlight: true
}, {
	name: 'campuses',
	display: 'name',
	source
}).bind('typeahead:select', () => {
	$('.form-inline').submit();
});

$('.form-inline').submit(function (evt) {
	evt.preventDefault();
	React.render(
		<Search query={this.querySelector('.tt-input').value} />,
		document.querySelector('main')
	);
});
