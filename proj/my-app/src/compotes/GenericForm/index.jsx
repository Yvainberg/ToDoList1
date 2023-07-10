import React from "react";
import { useForm } from "react-hook-form";
import styles from "./style.module.css";

export default function GenericForm({ fetchDataCreate,fetchDataUpData, initialValues  }) {

  const { register, handleSubmit, reset } = useForm();

  const handleFormSubmit = (data) => {
    console.log("--"+data.startdate);
    const formData = initialValues ? { ...data, id: initialValues.id } : data;
    initialValues ? fetchDataUpData(formData) : fetchDataCreate(formData);
    reset();
  };
  
  return (
    <div className={styles.list_container}>
      <form className={styles.list_form} onSubmit={handleSubmit(handleFormSubmit)}>
        <label>Name:</label>
        <input
          {...register("name", { required: true })}
          defaultValue={initialValues ? initialValues.name : " "}
          placeholder="Name"
        />

        <label>Description:</label>
        <input
          {...register("description", { minLength: 2 })}
          defaultValue={initialValues ? initialValues.description : " "}
          placeholder="Description"
        />

        <label>Start Date:</label>
        <input
          type="date"
          {...register("startdate")}
          defaultValue={initialValues ? initialValues.startdate : ""}
        />

        <label>End Date:</label>
        <input
          type="date"
          {...register("enddate")}
          defaultValue={initialValues ? initialValues.enddate : ""}
        />

        <label>Category:</label>
        <select
          {...register("category_id")}
          defaultValue={initialValues ? initialValues.category_id : ""}
        >
          <option value="">Select...</option>
          <option value="1">A</option>
          <option value="2">B</option>
          <option value="3">C</option>
        </select>
        <input type="submit" value="Submit" />
      </form>
    </div>
  );
}
