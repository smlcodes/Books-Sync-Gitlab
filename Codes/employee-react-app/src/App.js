
import './App.css';
import HeaderComponent from './component/HeaderComponent';
import HomeComponent from './component/HomeComponent';
import FooterComponent from './component/FooterComponent';
import ListAllEmployeesComponent from './component/ListAllEmployeesComponent';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import AddEmployeeComponent from './component/AddEmployeeComponent';
import EditEmployeeComponent from './component/EditEmployeeComponent';
import ViewEmployeeComponent from './component/ViewEmployeeComponent';
import DeleteEmployeeComponent from './component/DeleteEmployeeComponent';
function App() {
  return (

    <div>
      <HeaderComponent />

      <BrowserRouter>
        <div className="container">
          <Switch>
            <Route exact path="/" component={HomeComponent}></Route>
            <Route exact path="/addEmployee" component={AddEmployeeComponent}></Route>
            <Route exact path="/viewEmployee/:id" component={ViewEmployeeComponent}></Route>
            <Route exact path="/editEmployee/:id" component={EditEmployeeComponent}></Route>
            <Route exact path="/deleteEmployee/:id" component={DeleteEmployeeComponent}></Route>
            <Route exact path="/all" component={ListAllEmployeesComponent}></Route>
            <Route component={Error} />
          </Switch>
        </div>
      </BrowserRouter>

      <FooterComponent />
    </div>
  );
}
export default App;


