import React from 'react';
import { AsyncTypeahead } from 'react-bootstrap-typeahead';
import { useHistory } from 'react-router-dom';
import { searchUsers } from '../api/AxiosQueries';
import UserListItem from './subcomponents/searchfield/UserListItem.js';


const Search = () => {
    const [users, setUsers] = React.useState([]);
    const history = useHistory();

    const handleSearch = async (query) => {
        try {
            const users = await searchUsers(query);
            setUsers(users);
        } catch (err) {
            setUsers([]);
        }
    };

    const handleChange = ([user]) => {
        if (user) {
            history.push(`/users/${user.username}`);
        }
    };

    return <AsyncTypeahead
        id='users-search'
        labelKey='username'
        placeholder='Find users...'
        allowNew={false}
        multiple={false}
        options={users}
        onSearch={handleSearch}
        renderMenuItemChildren={(user) => <UserListItem user={user} />}
        inputProps={{ className: 'd-none d-sm-block' }}
        onChange={handleChange}
    />

};

export { Search };
