import axios from 'axios'
import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const [someText, setSomeText] = React.useState('nothing');
    axios.get('/hi')
    .then(response => {
      console.log(JSON.stringify(response.data));
      setSomeText(response.data);
    })
    .catch(() => console.log('error'));

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <h2>{someText}</h2>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
