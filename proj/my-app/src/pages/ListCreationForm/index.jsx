import * as React from "react";
import { useEffect } from "react";
import { useForm } from "react-hook-form";
import RequestAxios from "../../function/RequestAxios";
import GenericForm from "../../compotes/GenericForm";
import styles from "./style.module.css";

import { useContext } from 'react'
import DataContext from "../../context/dataContext";


export default function ListCreationForm() {

  const {setLoading} = useContext(DataContext);
 
  const fetchDataCreate = (data) => {
    try {
      setLoading(true);
      RequestAxios("/todolist/create", "POST", data);
      setLoading(false);
    } catch (error) {
      setLoading(false);
      console.log(error);
    }
  };


  
  return <GenericForm fetchDataCreate ={fetchDataCreate}   />;

}