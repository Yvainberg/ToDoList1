import './App.css';
import Header from "./Header";
import Home from "./Home";
import ContextManagment from "./context/ContextManagment"
import { useContext } from 'react'
import DataContext from "./context/dataContext";
import Spiner from './compotes/Spiner';


  

function App() {
  const {loading} = useContext(DataContext);

  return (
    <div className="App">
      <ContextManagment>
        <Header />
        <Home />
        {loading &&<Spiner/>}
      </ContextManagment>
    </div>
  );
}

export default App;
