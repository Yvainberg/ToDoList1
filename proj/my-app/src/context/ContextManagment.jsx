
import React, { useEffect, useState } from 'react'
import DataContext from './dataContext';


// main context for all data that we want to provide
function ContextManagment({ children }) {
    // This pattern allows you to globally control the creation of a popup, 
	// setpopupComponent accepts a component as value, 
	// setIsOpen true enabled false disabled
	const [popupComponent, setpopupComponent] = useState(null);
	const [isOpen, setIsOpen] = useState(false);

	const [stack, setStack] = useState(null);
	// This pattern allows you to dynamically control the loading state of a spinner component
	const [loading  ,setLoading] = useState(false);

	
	
	return <DataContext.Provider value={{
		
		popupComponent,
		setpopupComponent,
		
		isOpen,
		setIsOpen,

		stack,
		setStack,

		loading,
		setLoading,


	}}>
		{children}
	</DataContext.Provider>
}
export default ContextManagment;

