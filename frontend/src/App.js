import Home from './components/home';
import AddProduct from './components/addProduct';
import ViewProduct from './components/viewProduct';
import EditProduct from './components/editProduct';
import { Routes, Route, Outlet, Link } from "react-router-dom";
import Register from "./components/Register";
import Login from "./components/Login";
// import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  return (
    <Routes>
      <Route index element={<Home />} />
        <Route path="register" element={<Register />} />
        <Route path="login" element={<Login />} />

      <Route path="view/:id" element={<ViewProduct />} />
      <Route path="add" element={<AddProduct />} />
      <Route path="edit/:id" element={<EditProduct />} />
    {/* // <ViewProduct/>
    // <AddProduct />
    // <EditProduct/> */}
      
    </Routes>
  )
}

export default App;
