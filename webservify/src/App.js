import React from 'react';
import './App.css';
import {  BrowserRouter as Router,  Switch  } from "react-router-dom";
import { Layout,Menu} from 'antd';
import Home from  "./home";

const { Content, Footer } = Layout;

const handleClick = e => {
  console.log('click ', e);
};
function Nav() {
  return <Menu onClick={handleClick} mode="horizontal" style={{backgroundColor:'#f1f6f5', boxShadow:'0 4px 6px -6px #222', marginLeft:'2vw', marginRight:'2vw'}}>
        <Menu.Item><h3>Servify</h3></Menu.Item>
      </Menu>
}

function App() {

  return (
    <Layout style={{minHeight:'100vh'}}>
      <Nav/>
      <Router>
        <Layout style={{marginTop:'2vh',minHeight:'70vh'}}>
          <Content >
            <Switch path="/"><Home /></Switch>
          </Content>
        </Layout>
      </Router>
      <Footer style={{backgroundColor:'#1f1f1f', color:'#e6fffb', textAlign:'center',height:'10vh'}}><p style={{ color:'#e6fffb'}}>© Copyright 2020 </p></Footer>
    </Layout>  
  );
}

export default App;
