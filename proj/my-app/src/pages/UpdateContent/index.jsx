
import React from "react";
import RequestAxios from "../../function/RequestAxios";
import GenericForm from "../../compotes/GenericForm";
import { useContext } from 'react'
import DataContext from "../../context/dataContext";


export default function UpdateContent({ stack }) {

  const {setLoading} = useContext(DataContext);

  const fetchDataUpData = (data) => {
    console.log("fetchDataUpData =>", data);
    try {
      setLoading(true);
      RequestAxios("/todolist/update", "PUT", data);
      setLoading(false);
    } catch (error) {
      console.log(error);
    }
  };

  const initialValues = {
    id: stack.id,
    name: stack.name,
    description: stack.description,
    startdate: stack.startDate,
    enddate: stack.endDate,
    category_id: stack.category_id,
  };

  return (
    <div>
      
      <GenericForm fetchDataUpData={fetchDataUpData} initialValues={initialValues} />
    </div>
  );
}



